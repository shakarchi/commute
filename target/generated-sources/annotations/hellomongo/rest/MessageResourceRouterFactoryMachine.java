package hellomongo.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import hellomongo.rest.MessageResourceRouter;

@Machine
public class MessageResourceRouterFactoryMachine extends SingleNameFactoryMachine<hellomongo.rest.MessageResourceRouter> {
    public static final Name<hellomongo.rest.MessageResourceRouter> NAME = Name.of(hellomongo.rest.MessageResourceRouter.class, "MessageResourceRouter");

    public MessageResourceRouterFactoryMachine() {
        super(0, new StdMachineEngine<hellomongo.rest.MessageResourceRouter>(NAME, 0, BoundlessComponentBox.FACTORY) {
private final Factory.Query<hellomongo.rest.MessageResource> resource = Factory.Query.byClass(hellomongo.rest.MessageResource.class).mandatory();
private final Factory.Query<restx.entity.EntityRequestBodyReaderRegistry> readerRegistry = Factory.Query.byClass(restx.entity.EntityRequestBodyReaderRegistry.class).mandatory();
private final Factory.Query<restx.entity.EntityResponseWriterRegistry> writerRegistry = Factory.Query.byClass(restx.entity.EntityResponseWriterRegistry.class).mandatory();
private final Factory.Query<restx.converters.MainStringConverter> converter = Factory.Query.byClass(restx.converters.MainStringConverter.class).mandatory();
private final Factory.Query<javax.validation.Validator> validator = Factory.Query.byClass(javax.validation.Validator.class).optional();
private final Factory.Query<restx.security.RestxSecurityManager> securityManager = Factory.Query.byClass(restx.security.RestxSecurityManager.class).mandatory();

            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
resource,
readerRegistry,
writerRegistry,
converter,
validator,
securityManager
                ));
            }

            @Override
            protected hellomongo.rest.MessageResourceRouter doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new MessageResourceRouter(
satisfiedBOM.getOne(resource).get().getComponent(),
satisfiedBOM.getOne(readerRegistry).get().getComponent(),
satisfiedBOM.getOne(writerRegistry).get().getComponent(),
satisfiedBOM.getOne(converter).get().getComponent(),
satisfiedBOM.getOneAsComponent(validator),
satisfiedBOM.getOne(securityManager).get().getComponent()
                );
            }
        });
    }

}
