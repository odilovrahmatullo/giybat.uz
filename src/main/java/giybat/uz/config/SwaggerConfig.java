package giybat.uz.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Giybat",
                        email = "zaxriddinov1707@gmail.com",
                        url = "localhost"
                ),
                description = "This API exposes endpoints to manage tutorials.",
                title = "Giybat.uz Backend",
                version = "1.0",
                license = @License(
                        name = "Giybat.uz",
                        url = "localhost:8080"
                ),
                termsOfService = "Savol javob guruhi: https://t.me/zaxriddinovm"
        ),
        servers = {
                @io.swagger.v3.oas.annotations.servers.Server(
                        description = "DEV",
                        url = "localhost:8080"
                ),
                @io.swagger.v3.oas.annotations.servers.Server(
                        description = "LOCAL",
                        url = "http://localhost:8080"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "Bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)

public class SwaggerConfig {

}
