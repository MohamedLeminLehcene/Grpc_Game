package ma.enset.service;

import io.grpc.stub.StreamObserver;
import ma.enset.stubs.Jeu;
import ma.enset.stubs.VerfyNbrSecretGrpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class JeuService extends VerfyNbrSecretGrpc.VerfyNbrSecretImplBase {
    private final int nbrSecretServer;
    private boolean fin = false;
    private List<StreamObserver<Jeu.ClientResponse>> observers = new ArrayList<>();

    private Map<StreamObserver<Jeu.ClientResponse>, Integer> clients = new ConcurrentHashMap<>();

    private AtomicInteger nextClientId = new AtomicInteger(1);
    public JeuService() {
        this.nbrSecretServer = new Random().nextInt(1000);
    }


    @Override
    public StreamObserver<Jeu.ClientRequest> fullClientRequest(StreamObserver<Jeu.ClientResponse> responseObserver) {
        int clientId = nextClientId.getAndIncrement();
        clients.put(responseObserver, clientId);
        Jeu.ClientResponse response = Jeu.ClientResponse.newBuilder()

                .setClientId(clientId)
               // .setClientId(clientId)
                .setRequest("")
                .setResponse("Bienvenue! Veuillez entrer un nombre entre 0 et 1000 ID : "+clientId)
                .build();
        responseObserver.onNext(response);
        return new StreamObserver<>() {
            @Override
            public void onNext(Jeu.ClientRequest clientRequest) {
                System.out.println("Nbr secret server: " + nbrSecretServer + " nbrSecret client : " + clientRequest.getRequest());

                if (fin) {
                    Jeu.ClientResponse response = Jeu.ClientResponse.newBuilder()
                            .setRequest(clientRequest.getRequest())
                            .setResponse("Jeu Terminé par client : ")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    return;
                }

                int nbrSecretClient = Integer.parseInt(clientRequest.getRequest());
                if (nbrSecretClient > nbrSecretServer) {
                    Jeu.ClientResponse response = Jeu.ClientResponse.newBuilder()
                            .setRequest(clientRequest.getRequest())
                            .setResponse("Votre nombre est plus grand")
                            .build();
                    responseObserver.onNext(response);
                } else if (nbrSecretClient < nbrSecretServer) {
                    Jeu.ClientResponse response = Jeu.ClientResponse.newBuilder()
                            .setRequest(clientRequest.getRequest())
                            .setResponse("Votre nombre est plus petit")
                            .build();
                    responseObserver.onNext(response);
                } else {
                    Jeu.ClientResponse response = Jeu.ClientResponse.newBuilder()
                            .setClientId(clientId)
                            .setRequest(clientRequest.getRequest())
                            .setResponse("Bravo vous avez gagné")
                            .build();
                    responseObserver.onNext(response);
                    fin = true;

                    Jeu.ClientResponse response2 = Jeu.ClientResponse.newBuilder()
                            .setClientId(clientId)
                            .setRequest(clientRequest.getRequest())
                            .setResponse("jeu terminé, le gagnant est le client : " + clientId)
                            .build();

                    notifyAllObservers(response2, responseObserver);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                // Gestion de l'erreur
            }

            @Override
            public void onCompleted() {
                clients.remove(responseObserver);
            }

        };
    }

    private void notifyAllObservers(Jeu.ClientResponse response, StreamObserver<Jeu.ClientResponse> excludeObserver) {
        for (Map.Entry<StreamObserver<Jeu.ClientResponse>, Integer> entry : clients.entrySet()) {
            StreamObserver<Jeu.ClientResponse> observer = entry.getKey();
            int clientId = entry.getValue();
            if (observer != excludeObserver) {
                Jeu.ClientResponse.Builder builder = response.toBuilder();
               builder.setClientId(clientId);
                observer.onNext(builder.build());
                if (fin) {
                    observer.onCompleted();
                }
            }
        }
    }

}
