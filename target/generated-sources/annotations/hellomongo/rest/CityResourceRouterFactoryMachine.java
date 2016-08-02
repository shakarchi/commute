package hellomongo.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import hellomongo.rest.CityResourceRouter;

@Machine
public class CityResourceRouterFactoryMachine extends SingleNameFactoryMachine<hellomongo.rest.CityResourceRouter> {
    public static final Name<hellomongo.rest.CityResourceRouter> NAME = Name.of(hellomongo.rest.CityResourceRouter.class, "CityResourceRouter");

    public CityResourceRouterFactoryMachine() {
        super(0, new StdMachineEngine<hellomongo.rest.CityResourceRouter>(NAME, 0, BoundlessComponentBox.FACTORY) {
private final Factory.Query<hellomongo.rest.CityResource> resource = Factory.Query.byClass(hellomongo.rest.CityResource.class).mandatory();
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
            protected hellomongo.rest.CityResourceRouter doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new CityResourceRouter(
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
