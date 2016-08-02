package hellomongo.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import hellomongo.rest.MessageResource;

@Machine
public class MessageResourceFactoryMachine extends SingleNameFactoryMachine<hellomongo.rest.MessageResource> {
    public static final Name<hellomongo.rest.MessageResource> NAME = Name.of(hellomongo.rest.MessageResource.class, "MessageResource");

    public MessageResourceFactoryMachine() {
        super(0, new StdMachineEngine<hellomongo.rest.MessageResource>(NAME, 0, BoundlessComponentBox.FACTORY) {
private final Factory.Query<restx.jongo.JongoCollection> messages = Factory.Query.byName(Name.of(restx.jongo.JongoCollection.class, "messages")).mandatory();

            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
messages
                ));
            }

            @Override
            protected hellomongo.rest.MessageResource doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new MessageResource(
satisfiedBOM.getOne(messages).get().getComponent()
                );
            }
        });
    }

}
