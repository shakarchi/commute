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

public class CityResourceRouter extends RestxRouter {

    public CityResourceRouter(
                    final CityResource resource,
                    final EntityRequestBodyReaderRegistry readerRegistry,
                    final EntityResponseWriterRegistry writerRegistry,
                    final MainStringConverter converter,
                    final Optional<Validator> validator,
                    final RestxSecurityManager securityManager) {
        super(
            "default", "CityResourceRouter", new RestxRoute[] {
        new StdEntityRoute<Void, java.lang.Iterable<hellomongo.domain.City>>("default#CityResource#findCities",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<java.lang.Iterable<hellomongo.domain.City>>build(Types.newParameterizedType(java.lang.Iterable.class, hellomongo.domain.City.class), Optional.<String>absent()),
                new StdRestxRequestMatcher("GET", "/cities"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<java.lang.Iterable<hellomongo.domain.City>> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.findCities(
                        /* [QUERY] name */ request.getQueryParam("name")
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription name = new OperationParameterDescription();
                name.name = "name";
                name.paramType = OperationParameterDescription.ParamType.query;
                name.dataType = "string";
                name.schemaKey = "";
                name.required = false;
                operation.parameters.add(name);


                operation.responseClass = "LIST[City]";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "hellomongo.domain.City";
                operation.sourceLocation = "hellomongo.rest.CityResource#findCities(com.google.common.base.Optional<java.lang.String>)";
            }
        },
        new StdEntityRoute<hellomongo.domain.City, hellomongo.domain.City>("default#CityResource#createCity",
                readerRegistry.<hellomongo.domain.City>build(hellomongo.domain.City.class, Optional.<String>absent()),
                writerRegistry.<hellomongo.domain.City>build(hellomongo.domain.City.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("POST", "/cities"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<hellomongo.domain.City> doRoute(RestxRequest request, RestxRequestMatch match, hellomongo.domain.City body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.createCity(
                        /* [BODY] city */ checkValid(validator, body)
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription city = new OperationParameterDescription();
                city.name = "city";
                city.paramType = OperationParameterDescription.ParamType.body;
                city.dataType = "City";
                city.schemaKey = "hellomongo.domain.City";
                city.required = true;
                operation.parameters.add(city);


                operation.responseClass = "City";
                operation.inEntitySchemaKey = "hellomongo.domain.City";
                operation.outEntitySchemaKey = "hellomongo.domain.City";
                operation.sourceLocation = "hellomongo.rest.CityResource#createCity(hellomongo.domain.City)";
            }
        },
        new StdEntityRoute<Void, hellomongo.domain.City>("default#CityResource#findCityById",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<hellomongo.domain.City>build(hellomongo.domain.City.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("GET", "/cities/{oid}"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<hellomongo.domain.City> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return resource.findCityById(
                        /* [PATH] oid */ match.getPathParam("oid")
                );
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription oid = new OperationParameterDescription();
                oid.name = "oid";
                oid.paramType = OperationParameterDescription.ParamType.path;
                oid.dataType = "string";
                oid.schemaKey = "";
                oid.required = true;
                operation.parameters.add(oid);


                operation.responseClass = "City";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "hellomongo.domain.City";
                operation.sourceLocation = "hellomongo.rest.CityResource#findCityById(java.lang.String)";
            }
        },
        new StdEntityRoute<hellomongo.domain.City, hellomongo.domain.City>("default#CityResource#updateCity",
                readerRegistry.<hellomongo.domain.City>build(hellomongo.domain.City.class, Optional.<String>absent()),
                writerRegistry.<hellomongo.domain.City>build(hellomongo.domain.City.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("PUT", "/cities/{oid}"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<hellomongo.domain.City> doRoute(RestxRequest request, RestxRequestMatch match, hellomongo.domain.City body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.updateCity(
                        /* [PATH] oid */ match.getPathParam("oid"),
                        /* [BODY] city */ checkValid(validator, body)
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription oid = new OperationParameterDescription();
                oid.name = "oid";
                oid.paramType = OperationParameterDescription.ParamType.path;
                oid.dataType = "string";
                oid.schemaKey = "";
                oid.required = true;
                operation.parameters.add(oid);

                OperationParameterDescription city = new OperationParameterDescription();
                city.name = "city";
                city.paramType = OperationParameterDescription.ParamType.body;
                city.dataType = "City";
                city.schemaKey = "hellomongo.domain.City";
                city.required = true;
                operation.parameters.add(city);


                operation.responseClass = "City";
                operation.inEntitySchemaKey = "hellomongo.domain.City";
                operation.outEntitySchemaKey = "hellomongo.domain.City";
                operation.sourceLocation = "hellomongo.rest.CityResource#updateCity(java.lang.String,hellomongo.domain.City)";
            }
        },
        new StdEntityRoute<Void, restx.Status>("default#CityResource#deleteCity",
                readerRegistry.<Void>build(Void.class, Optional.<String>absent()),
                writerRegistry.<restx.Status>build(restx.Status.class, Optional.<String>absent()),
                new StdRestxRequestMatcher("DELETE", "/cities/{oid}"),
                HttpStatus.OK, RestxLogLevel.DEFAULT) {
            @Override
            protected Optional<restx.Status> doRoute(RestxRequest request, RestxRequestMatch match, Void body) throws IOException {
                securityManager.check(request, open());
                return Optional.of(resource.deleteCity(
                        /* [PATH] oid */ match.getPathParam("oid")
                ));
            }

            @Override
            protected void describeOperation(OperationDescription operation) {
                super.describeOperation(operation);
                                OperationParameterDescription oid = new OperationParameterDescription();
                oid.name = "oid";
                oid.paramType = OperationParameterDescription.ParamType.path;
                oid.dataType = "string";
                oid.schemaKey = "";
                oid.required = true;
                operation.parameters.add(oid);


                operation.responseClass = "Status";
                operation.inEntitySchemaKey = "";
                operation.outEntitySchemaKey = "restx.Status";
                operation.sourceLocation = "hellomongo.rest.CityResource#deleteCity(java.lang.String)";
            }
        },
        });
    }

}
