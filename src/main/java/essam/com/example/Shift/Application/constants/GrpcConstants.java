package essam.com.example.Shift.Application.constants;

import essam.com.example.Shift.Application.models.User;
import io.grpc.Context;
import io.grpc.Metadata;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

public class GrpcConstants {
    public static final Metadata.Key<String> AUTHORIZATION_METADATA_KEY = Metadata.Key.of("Authorization", ASCII_STRING_MARSHALLER);
    public static final Context.Key<User> USER_KEY = Context.key("user");

    private GrpcConstants() {
        throw new AssertionError();
    }
}