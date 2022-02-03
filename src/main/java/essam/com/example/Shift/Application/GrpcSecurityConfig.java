package essam.com.example.Shift.Application;

import essam.com.example.Shift.Application.grpc.ShiftServiceGrpc;
import org.lognet.springboot.grpc.security.GrpcSecurity;
import org.lognet.springboot.grpc.security.GrpcSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcSecurityConfig extends GrpcSecurityConfigurerAdapter {
    @Override
    public void configure(GrpcSecurity builder) throws Exception {
        builder.authorizeRequests().methods(ShiftServiceGrpc.getFindOneMethod()).authenticated();
        builder.authorizeRequests().methods(ShiftServiceGrpc.getCreateShiftMethod()).authenticated();
    }
}
