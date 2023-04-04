package ma.enset.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ma.enset.service.JeuService;

public class GrpcJeuServeur {
    public static void main(String[] args)  throws Exception{
        Server server = ServerBuilder.forPort(888)
                .addService(new JeuService())
                .build();
        server.start();
        server.awaitTermination();

    }
}
