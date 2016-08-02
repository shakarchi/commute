package hellomongo;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import hellomongo.AppModule;


@Machine
public class AppModuleFactoryMachine extends DefaultFactoryMachine {
    private static final AppModule module = new AppModule();

    public AppModuleFactoryMachine() {
        super(0, new MachineEngine[] {
            new StdMachineEngine<restx.security.SignatureKey>(Name.of(restx.security.SignatureKey.class, "signatureKey"), 0, BoundlessComponentBox.FACTORY) {
        
                @Override
                public BillOfMaterials getBillOfMaterial() {
                    return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
        
                    ));
                }

                @Override
                public restx.security.SignatureKey doNewComponent(SatisfiedBOM satisfiedBOM) {
	                
	                    return module.signatureKey(
	        
	                    );
	                
                }
            },
            new StdMachineEngine<java.lang.String>(Name.of(java.lang.String.class, "mongo.db"), 0, BoundlessComponentBox.FACTORY) {
        
                @Override
                public BillOfMaterials getBillOfMaterial() {
                    return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
        
                    ));
                }

                @Override
                public java.lang.String doNewComponent(SatisfiedBOM satisfiedBOM) {
	                
	                    return module.dbName(
	        
	                    );
	                
                }
            },
            new StdMachineEngine<restx.security.CORSAuthorizer>(Name.of(restx.security.CORSAuthorizer.class, "allowCORS"), 0, BoundlessComponentBox.FACTORY) {
        
                @Override
                public BillOfMaterials getBillOfMaterial() {
                    return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
        
                    ));
                }

                @Override
                public restx.security.CORSAuthorizer doNewComponent(SatisfiedBOM satisfiedBOM) {
	                
	                    return module.allowCORS(
	        
	                    );
	                
                }
            },

        });
    }
}
