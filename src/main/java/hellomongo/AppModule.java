package hellomongo;

import com.google.common.base.Charsets;
import com.google.common.base.Predicates;

import com.google.common.collect.ImmutableList;
import com.google.common.*;
import restx.mongo.MongoModule;
import restx.security.SignatureKey;
import restx.factory.Module;
import restx.factory.Provides;
import restx.security.*;
import javax.inject.Named;
import com.google.common.base.Optional;

@Module
public class AppModule {
    @Provides
    public SignatureKey signatureKey() {
         return new SignatureKey("3685755889849339038 636b37d4-f945-4a6b-8fea-31900e12861a restx-samples-hellomongo restx-samples-hellomongo".getBytes(Charsets.UTF_8));
    }

    @Provides @Named(MongoModule.MONGO_DB_NAME)
    public String dbName() {
        return "restx-hellomongo";
    }

    @Provides
    public CORSAuthorizer allowCORS() {
        return StdCORSAuthorizer.builder()
                .setOriginMatcher(Predicates.<CharSequence>alwaysTrue())
                .setPathMatcher(Predicates.<CharSequence>alwaysTrue())
                .setAllowedMethods(ImmutableList.of("GET", "POST", "PUT", "DELETE", "HEAD"))
                .setAllowedHeaders(ImmutableList.of("Origin", "X-Requested-With", "Content-Type", "Accept"))
                .setAllowCredentials(Optional.of(Boolean.TRUE))
                .build();
    }

}
