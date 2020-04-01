package vlada.spring.walterauthservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig  extends AuthorizationServerConfigurerAdapter {

    static final String ANGULAR_CLIEN_ID = "angular-client";
    static final String ANGULAR_CLIENT_SECRET = "angular-secret";

    static final String RESOURCE_CLIEN_ID = "resource-client";
    static final String RESOURCE_CLIENT_SECRET ="resource-secret";

    static final String ZAPOSLENI_RESOURCE_CLIEN_ID = "zaposleni-resource-client";
    static final String ZAPOSLENI_RESOURCE_CLIENT_SECRET ="zaposleni-resource-secret";

    static final String PUTNICI_RESOURCE_CLIEN_ID = "putnici-resource-client";
    static final String PUTNICI_RESOURCE_CLIENT_SECRET ="putnici-resource-secret";

    static final String VOZACI_RESOURCE_CLIEN_ID = "vozaci-resource-client";
    static final String VOZACI_RESOURCE_CLIENT_SECRET ="vozaci-resource-secret";

    static final String TURA_RESOURCE_CLIEN_ID = "tura-resource-client";
    static final String TURA_RESOURCE_CLIENT_SECRET ="tura-resource-secret";

    static final String GRANT_TYPE_PASSWORD = "password";
    static final String AUTHORIZATION_CODE = "authorization_code";
    static final String REFRESH_TOKEN = "refresh_token";
    static final String IMPLICIT = "implicit";
    static final String SCOPE_READ = "read";
    static final String SCOPE_WRITE = "write";
    static final String TRUST = "trust";
    static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
    static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Bean
    public JwtAccessTokenConverter accessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(new ClassPathResource("mypass.jks"), "mypass".toCharArray());
        converter.setKeyPair(factory.getKeyPair("linh"));
        return converter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

        configurer
                .inMemory()
                .withClient(ANGULAR_CLIEN_ID)
                .secret(passwordEncoder.encode(ANGULAR_CLIENT_SECRET))
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
                .refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS)
                .and()
                .withClient(RESOURCE_CLIEN_ID)
                .secret(passwordEncoder.encode(RESOURCE_CLIENT_SECRET))
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .and()
                .withClient(ZAPOSLENI_RESOURCE_CLIEN_ID)
                .secret(passwordEncoder.encode(ZAPOSLENI_RESOURCE_CLIENT_SECRET))
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .and()
                .withClient(PUTNICI_RESOURCE_CLIEN_ID)
                .secret(passwordEncoder.encode(PUTNICI_RESOURCE_CLIENT_SECRET))
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .and()
                .withClient(VOZACI_RESOURCE_CLIEN_ID)
                .secret(passwordEncoder.encode(VOZACI_RESOURCE_CLIENT_SECRET))
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .and()
                .withClient(TURA_RESOURCE_CLIEN_ID)
                .secret(passwordEncoder.encode(TURA_RESOURCE_CLIENT_SECRET))
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .accessTokenConverter(accessTokenConverter());
    }



}

