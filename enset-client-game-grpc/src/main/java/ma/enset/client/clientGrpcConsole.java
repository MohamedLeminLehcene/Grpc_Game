package ma.enset.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import ma.enset.stubs.Jeu;
import ma.enset.stubs.VerfyNbrSecretGrpc;

import java.util.Scanner;

public class clientGrpcConsole {


    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",888)
                .usePlaintext()
                .build();

        VerfyNbrSecretGrpc.VerfyNbrSecretStub asyncStub = VerfyNbrSecretGrpc.newStub(managedChannel);

        StreamObserver<Jeu.ClientRequest> clientRequestStream = asyncStub.fullClientRequest(new StreamObserver<Jeu.ClientResponse>() {
            @Override
            public void onNext(Jeu.ClientResponse clientResponse) {
                System.out.println("=====================");
                System.out.println(clientResponse.getResponse());
                System.out.println("=====================");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        });



        Scanner sc = new Scanner(System.in);

        while (true) {
            String message = sc.next();
            Jeu.ClientRequest clientRequest = Jeu.ClientRequest.newBuilder()
                    .setRequest(message)
                    .build();
            clientRequestStream.onNext(clientRequest);
        }
    }



    /*

     */
}
