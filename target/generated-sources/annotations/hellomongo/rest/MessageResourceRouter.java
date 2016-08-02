package hellomongo.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.base.Optional;
import static com.google.common.base.Preconditions.checkNotNull;

import restx.common.Types;
import restx.*;
import restx.entity.*;
import restx.http.*;
import restx.factory.*;
import restx.security.*;
import static restx.security.Permissions.*;
import restx.description.*;
import restx.converters.MainStringConverter;
import static restx.common.MorePreconditions.checkPresent;

import javax.validation.Validator;
import static restx.validation.Validations.checkValid;

import java.io.IOException;
import java.io.PrintWriter;

@Component(priority = 0)

public class MessageResourceRouter extends RestxRouter {

    public MessageResourceRouter(
                    final MessageResource resource,
                    final EntityRequestBodyReaderRegistry readerRegistry,
                    final EntityResponseWriterRegistry writerRegistry,
                    final MainStringConverter converter,
                    final Optional<Validator> validator,
                    final RestxSecurityManager securityManager) {
        super(
            "default", "MessageResourceRouter", new RestxRoute[] {
        new StdEntityRoute<Void, java.lang.Iterable<hellomongo.domain.Message>>("default#MessageResource#getMessages",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<java.lang.Iterable<hellomongo.domain.Message>>build(Types.newParameterizedType(java.lang.Iterable.class, hellomongo.domain.Message.class), Optional.<String>absent()),
                new StdRestxRequestMatcher("GET", "/messages"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<java.lang.Iterable<hellomongo.domain.Message>> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.getMessages(
                        
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                

                operation.responseClass = "LIST[Message]";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "hellomongo.domain.Message";
                operation.sourceLocation = "hellomongo.rest.MessageResource#getMessages()";
            }
        },
        new StdEntityRoute<hellomongo.domain.Message, hellomongo.domain.Message>("default#MessageResource#createMessage",
                readerRegistry.<hellomongo.domain.Message>build(hellomongo.domain.Message.class, Optional.<String>absent()),
                writerRegistry.<hellomongo.domain.Message>build(hellomongo.domain.Message.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("POST", "/messages"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<hellomongo.domain.Message> doRoute(RestxRequest request, RestxRequestMatch match, hellomongo.domain.Message body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.createMessage(
                        /* [BODY] message */ checkValid(validator, body)
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription message = new OperationParameterDescription();
                message.name = "message";
                message.paramType = OperationParameterDescription.ParamType.body;
                message.dataType = "Message";
                message.schemaKey = "hellomongo.domain.Message";
                message.required = true;
                operation.parameters.add(message);


                operation.responseClass = "Message";
                operation.inEntitySchemaKey = "hellomongo.domain.Message";
                operation.outEntitySchemaKey = "hellomongo.domain.Message";
                operation.sourceLocation = "hellomongo.rest.MessageResource#createMessage(hellomongo.domain.Message)";
            }
        },
        });
    }

}
