package hellomongo.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import hellomongo.rest.CityResource;

@Machine
public class CityResourceFactoryMachine extends SingleNameFactoryMachine<hellomongo.rest.CityResource> {
    public static final Name<hellomongo.rest.CityResource> NAME = Name.of(hellomongo.rest.CityResource.class, "CityResource");

    public CityResourceFactoryMachine() {
        super(0, new StdMachineEngine<hellomongo.rest.CityResource>(NAME, 0, BoundlessComponentBox.FACTORY) {
private final Factory.Query<restx.jongo.JongoCollection> cities = Factory.Query.byName(Name.of(restx.jongo.JongoCollection.class, "cities")).mandatory();

            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
cities
                ));
            }

            @Override
            protected hellomongo.rest.CityResource doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new CityResource(
satisfiedBOM.getOne(cities).get().getComponent()
                );
            }
        });
    }

}
