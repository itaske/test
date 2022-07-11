package com.example.testinggroudweb.patrick.service;

import com.example.testinggroudweb.patrick.model.branches.Branches;
import com.example.testinggroudweb.patrick.model.casenotlifepremium.CaseNotLifePremium;
import com.example.testinggroudweb.patrick.model.cedants.Cedants;
import com.example.testinggroudweb.patrick.model.countries.Countries;
import com.example.testinggroudweb.patrick.model.employees.Employees;
import com.example.testinggroudweb.patrick.model.groupscedant.GroupsCedant;
import com.example.testinggroudweb.patrick.model.region.Region;
import com.example.testinggroudweb.patrick.model.response.Response;
import com.example.testinggroudweb.patrick.model.slipspremium.SlipPremium;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author Patrick Udochukwu
 */

@Service
public class RECRiskService {
    public static final String ID = "$oid";
    private static HashMap<String, CaseNotLifePremium> caseNotLifePremiumHashMap = new HashMap<>();
    private static HashMap<String, SlipPremium> slipPremiumHashMap = new HashMap<>();
    private static HashMap<String, Branches> branchesHashMap = new HashMap<>();
    private static HashMap<String, Region> regionHashMap = new HashMap<>();
    private static HashMap<String, GroupsCedant> groupsCedantHashMap = new HashMap<>();
    private static HashMap<String, Employees> employeesHashMap = new HashMap<>();
    private static HashMap<String, Countries> countriesHashMap = new HashMap<>();
    private static HashMap<String, Cedants> cedantsHashMap = new HashMap<>();

    private static String[] files = {"slips_premium.json", "case_not_life_premium.json", "region.json",
            "groups_cedants.json", "countries.json", "cedants.json", "branches.json", "employees.json"};
    private static String[] testCasesId = {"5de7d0ed329d8746112bef92", "5ebbfec8329d8763057a4014", "5ec3e07e329d8748f31aa8c2"};
    private static String[] testCasesName = {"Hyper non vie assurance", "Kied ASSUR", "Paix assur"};


    private StringBuilder readFileRecordsToMemory(String path) throws IOException, ParseException {
        FileInputStream inputStream = null;
        Scanner sc = null;
        StringBuilder sb = new StringBuilder();
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
            }
            // note that this Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        //Read JSON file
        Object obj = jsonParser.parse(sb.toString());

        //get JSON Array
        JSONArray jsonArray = (JSONArray) obj;

        switch (path) {
            case "case_not_life_premium.json": {
                jsonArray.forEach(cnlp -> {
                    //Get object within list
                    JSONObject cnlpObject = (JSONObject) cnlp;

                    //map to pojo
                    GsonBuilder builder = new GsonBuilder();
                    builder.setPrettyPrinting();
                    Gson gson = builder.create();


                    CaseNotLifePremium caseNotLifePremium = gson.fromJson(cnlpObject.toJSONString(), CaseNotLifePremium.class);
//                    System.out.println(caseNotLifePremium.get_id().get(ID).toString());


                    caseNotLifePremiumHashMap.put(caseNotLifePremium.get_id().get(ID).toString(), caseNotLifePremium);
                });
            }
            case "slips_premium.json": {
                jsonArray.forEach(slips -> {
                    //Get object within list
                    JSONObject slipsPremiumObject = (JSONObject) slips;

                    //map to pojo
                    GsonBuilder builder = new GsonBuilder();
                    builder.setPrettyPrinting();
                    Gson gson = builder.create();


                    SlipPremium slipPremium = gson.fromJson(slipsPremiumObject.toJSONString(), SlipPremium.class);
//                    System.out.println(caseNotLifePremium.get_id().get(ID).toString());


                    slipPremiumHashMap.put(slipPremium.get_id().get(ID).toString(), slipPremium);
                });

                break;
            }
            case "region.json": {
                jsonArray.forEach(rgn -> {
                    //Get object within list
                    JSONObject regionObject = (JSONObject) rgn;

                    //map to pojo
                    GsonBuilder builder = new GsonBuilder();
                    builder.setPrettyPrinting();
                    Gson gson = builder.create();


                    Region region = gson.fromJson(regionObject.toJSONString(), Region.class);
//                    System.out.println(caseNotLifePremium.get_id().get(ID).toString());


                    regionHashMap.put(region.get_id().toString(), region);
                });

                break;
            }
            case "groups_cedants.json": {
                jsonArray.forEach(groupCdnt -> {
                    //Get object within list
                    JSONObject groupCedantsObject = (JSONObject) groupCdnt;

                    //map to pojo
                    GsonBuilder builder = new GsonBuilder();
                    builder.setPrettyPrinting();
                    Gson gson = builder.create();


                    GroupsCedant groupsCedant = gson.fromJson(groupCedantsObject.toJSONString(), GroupsCedant.class);
//                    System.out.println(caseNotLifePremium.get_id().get(ID).toString());


                    groupsCedantHashMap.put(groupsCedant.get_id().get(ID).toString(), groupsCedant);
                });

                break;
            }

            case "branches.json": {
                jsonArray.forEach(branch -> {
                    //Get object within list
                    JSONObject branchObject = (JSONObject) branch;

                    //map to pojo
                    GsonBuilder builder = new GsonBuilder();
                    builder.setPrettyPrinting();
                    Gson gson = builder.create();


                    Branches branches = gson.fromJson(branchObject.toJSONString(), Branches.class);
//                    System.out.println(caseNotLifePremium.get_id().get(ID).toString());


                    branchesHashMap.put(branches.get_id().get(ID).toString(), branches);
                });

                break;
            }
            case "cedants.json": {
                jsonArray.forEach(cdnts -> {
                    //Get object within list
                    JSONObject cedantsObject = (JSONObject) cdnts;

                    //map to pojo
                    GsonBuilder builder = new GsonBuilder();
                    builder.setPrettyPrinting();
                    Gson gson = builder.create();


                    Cedants cedants = gson.fromJson(cedantsObject.toJSONString(), Cedants.class);
//                    System.out.println(caseNotLifePremium.get_id().get(ID).toString());


                    cedantsHashMap.put(cedants.get_id().get(ID).toString(), cedants);
                });

                break;
            }
            case "countries.json": {
                jsonArray.forEach(country -> {
                    //Get object within list
                    JSONObject countryObject = (JSONObject) country;

                    //map to pojo
                    GsonBuilder builder = new GsonBuilder();
                    builder.setPrettyPrinting();
                    Gson gson = builder.create();


                    Countries countries = gson.fromJson(countryObject.toJSONString(), Countries.class);
//                    System.out.println(caseNotLifePremium.get_id().get(ID).toString());


                    countriesHashMap.put(countries.get_id().get(ID).toString(), countries);
                });

                break;
            }
            case "employees.json": {
                jsonArray.forEach(branch -> {
                    //Get object within list
                    JSONObject employeesObject = (JSONObject) branch;

                    //map to pojo
                    GsonBuilder builder = new GsonBuilder();
                    builder.setPrettyPrinting();
                    Gson gson = builder.create();


                    Employees employees = gson.fromJson(employeesObject.toJSONString(), Employees.class);
//                    System.out.println(caseNotLifePremium.get_id().get(ID).toString());


                    employeesHashMap.put(employees.getEmployee().getWebsite(), employees);
                });

                break;
            }
        }

//        System.out.println("caseNotLifePremiumHashMap".toUpperCase(Locale.ROOT));
//        caseNotLifePremiumHashMap.entrySet().forEach(x -> System.out.println(x.getValue().getPremium_ht()));
//        System.out.println("slipPremiumHashMap");
//        slipPremiumHashMap.entrySet().forEach(x -> System.out.println(x.getKey()));
//        System.out.println("regionHashMap");
//        regionHashMap.entrySet().forEach(x -> System.out.println(x.getKey()));
//
//        System.out.println("groupsCedantHashMap");
//        groupsCedantHashMap.entrySet().forEach(x -> System.out.println(x.getKey()));
//
//        System.out.println("branchesHashMap");
//        branchesHashMap.entrySet().forEach(x -> System.out.println(x.getKey()));
//
//        System.out.println("countriesHashMap");
//        countriesHashMap.entrySet().forEach(x -> System.out.println(x.getKey()));
//
//        System.out.println("employeesHashMap");
//        employeesHashMap.entrySet().forEach(x -> System.out.println(x.getKey()));
//        System.out.println("cedantsHashMap");
//        cedantsHashMap.entrySet().forEach(x -> System.out.println(x.getKey()));


        String[] testCasesId = {"5de7d0ed329d8746112bef92", "5ebbfec8329d8763057a4014", "5ec3e07e329d8748f31aa8c2"};
        String[] testCasesName = {"Hyper non vie assurance", "Kied ASSUR", "Paix assur"};


//        findRecord(testCasesId[0], testCasesName[0]);
        return null;
    }

    public List<Response> findCedantsRec(String id) {

        Arrays.stream(files).forEach(x -> {
            try {
                readFileRecordsToMemory(x);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        HashMap<String, Cedants> foundCedants = new HashMap<>();
        HashMap<String, Response> responseHashMap = new HashMap<>();
        List<Response> responseList = new ArrayList<>();
        cedantsHashMap.entrySet().forEach(cedantEntry -> {

//            Search cedantsHashmap and put
            if (cedantEntry.getKey().equals(id)) {
                foundCedants.put(id, cedantEntry.getValue());
            }
        });

        foundCedants.entrySet().forEach(cedntsEntry -> {
            Response response = new Response();

//            get cedant record object
            Cedants cedants = cedantsHashMap.get(cedntsEntry.getKey());
            response.setCedants(cedants.getName());

            String countryId = cedants.getCountries_id().get(ID).toString();
            countriesHashMap.entrySet().forEach(countryEntry -> {
                if (countryEntry.getKey().equalsIgnoreCase(countryId)) {
                    Countries country = countriesHashMap.get(countryEntry.getKey());
                    response.setCountry(country.getName());
                }
            });

            //get matching rec in Slips_premium map
            slipPremiumHashMap.entrySet().forEach(y -> {
                SlipPremium slipPremium = slipPremiumHashMap.get(y.getKey());
                if (slipPremium.getCedants_id().get(ID).equals(cedntsEntry.getKey())) {
//                    foundSlipsPremium.put(cedntsEntry.getKey(),slipPremium);
                    response.setReference(slipPremium.getReference());
                    response.setValidationStatus(slipPremium.getValidation_status());
                    response.setConfirmationStatus(slipPremium.getConfirmation_status());
                    response.setPublicationDate(slipPremium.getPublished_date());


                    //search cedant with cedntsEntry key and find matching case not life record
                    caseNotLifePremiumHashMap.entrySet().forEach(caseNotLifePremiumEntry -> {
                        StringBuilder branches = new StringBuilder();
                        if (caseNotLifePremiumEntry.getKey().equalsIgnoreCase(cedntsEntry.getKey())) {
                            CaseNotLifePremium caseNotLifePremium = caseNotLifePremiumHashMap.get(caseNotLifePremiumEntry.getKey());
                            String branch = caseNotLifePremium.getBranch();
                            branches.append(branch).append(", ");

                            response.setCalculatedREC(caseNotLifePremium.getPremium_ht());
                        }
                        response.setBranche(branches.toString());
                    });

                }

                responseHashMap.put(cedntsEntry.getKey(), response);
            });


        });

        responseHashMap.entrySet().forEach(e -> {
            responseList.add(responseHashMap.get(e.getKey()));
        });

        return responseList;
    }


    public Set<Response> searchRec(String reference, String validationStatus, String confirmationStatus, String publicationDate) {
        Arrays.stream(files).forEach(x -> {

            try {
                readFileRecordsToMemory(x);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        });

        HashMap<String, Response> responseHashMap = new HashMap<>();
        Set<Response> responseList = new HashSet<>();


        try {
            cedantsHashMap.entrySet().forEach(cedantEntry -> {
                slipPremiumHashMap.entrySet().forEach(slipPremiumEntry -> {
                    SlipPremium slipPremium = slipPremiumHashMap.get(slipPremiumEntry.getKey());

                    if (!reference.isBlank() && reference.equalsIgnoreCase(slipPremium.getReference())) {
                        Response response = new Response();

                        response.setReference(slipPremium.getReference());
                        response.setValidationStatus(slipPremium.getValidation_status());
                        response.setConfirmationStatus(slipPremium.getConfirmation_status());
                        response.setPublicationDate(slipPremium.getPublished_date());

                        var ref = new Object() {
                            double sum = 0;
                        };
                        //search cedant with cedntsEntry key and find matching case not life record
                        caseNotLifePremiumHashMap.entrySet().forEach(caseNotLifePremiumEntry -> {

                            StringBuilder branches = new StringBuilder();
                            if (caseNotLifePremiumEntry.getKey().equalsIgnoreCase(slipPremium.getReference())) {
                                CaseNotLifePremium caseNotLifePremium = caseNotLifePremiumHashMap.get(caseNotLifePremiumEntry.getKey());
                                String branch = caseNotLifePremium.getBranch();
                                branches.append(branch).append(", ");
                                ref.sum += caseNotLifePremium.getPremium_ht();
                                System.out.println(ref.sum);
                                response.setCalculatedREC(ref.sum);
                            }
                            response.setBranche(branches.toString());
                        });
                        System.out.println(response);
                        responseHashMap.put(reference, response);
                        responseList.add(response);

                    }

                    if (!validationStatus.isBlank() && validationStatus.equalsIgnoreCase(slipPremium.getValidation_status())) {
                        Response response = new Response();
//                    foundSlipsPremium.put(cedntsEntry.getKey(),slipPremium);
                        response.setReference(slipPremium.getReference());
                        response.setValidationStatus(slipPremium.getValidation_status());
                        response.setConfirmationStatus(slipPremium.getConfirmation_status());
                        response.setPublicationDate(slipPremium.getPublished_date());


                        //search cedant with cedntsEntry key and find matching case not life record
                        caseNotLifePremiumHashMap.entrySet().forEach(caseNotLifePremiumEntry -> {
                            StringBuilder branches = new StringBuilder();
                            if (caseNotLifePremiumEntry.getKey().equalsIgnoreCase(slipPremium.getReference())) {
                                CaseNotLifePremium caseNotLifePremium = caseNotLifePremiumHashMap.get(caseNotLifePremiumEntry.getKey());
                                String branch = caseNotLifePremium.getBranch();
                                branches.append(branch).append(", ");

                                response.setCalculatedREC(caseNotLifePremium.getPremium_ht());
                            }
                            response.setBranche(branches.toString());
                        });
                        responseHashMap.put(reference, response);
                        responseList.add(response);

                    }

                    if (!confirmationStatus.isBlank() && confirmationStatus.equalsIgnoreCase(slipPremium.getConfirmation_status())) {
                        Response response = new Response();
//                    foundSlipsPremium.put(cedntsEntry.getKey(),slipPremium);
                        response.setReference(slipPremium.getReference());
                        response.setValidationStatus(slipPremium.getValidation_status());
                        response.setConfirmationStatus(slipPremium.getConfirmation_status());
                        response.setPublicationDate(slipPremium.getPublished_date());


                        //search cedant with cedntsEntry key and find matching case not life record
                        caseNotLifePremiumHashMap.entrySet().forEach(caseNotLifePremiumEntry -> {
                            StringBuilder branches = new StringBuilder();
                            if (caseNotLifePremiumEntry.getKey().equalsIgnoreCase(slipPremium.getReference())) {
                                CaseNotLifePremium caseNotLifePremium = caseNotLifePremiumHashMap.get(caseNotLifePremiumEntry.getKey());
                                String branch = caseNotLifePremium.getBranch();
                                branches.append(branch);

                                response.setCalculatedREC(caseNotLifePremium.getPremium_ht());
                            }
                            response.setBranche(branches.toString());
                        });
                        responseHashMap.put(reference, response);
                        responseList.add(response);

                    }

                    if (!publicationDate.isBlank() && publicationDate.equalsIgnoreCase(slipPremium.getPublished_date())) {
                        Response response = new Response();
                        response.setReference(slipPremium.getReference());
                        response.setValidationStatus(slipPremium.getValidation_status());
                        response.setConfirmationStatus(slipPremium.getConfirmation_status());
                        response.setPublicationDate(slipPremium.getPublished_date());


                        //search cedant with cedntsEntry key and find matching case not life record
                        caseNotLifePremiumHashMap.entrySet().forEach(caseNotLifePremiumEntry -> {
                            StringBuilder branches = new StringBuilder();
                            if (caseNotLifePremiumEntry.getKey().equalsIgnoreCase(slipPremium.getReference())) {
                                CaseNotLifePremium caseNotLifePremium = caseNotLifePremiumHashMap.get(caseNotLifePremiumEntry.getKey());
                                String branch = caseNotLifePremium.getBranch();
                                branches.append(branch).append(", ");

                                response.setCalculatedREC(caseNotLifePremium.getPremium_ht());
                            }
                            response.setBranche(branches.toString());
                        });
                        System.out.println(response);
                        responseHashMap.put(reference, response);
                        responseList.add(response);

                    }

                });
            });

            responseList.forEach(x -> System.out.println(x));

            System.out.println("*******************************************************");
            responseHashMap.entrySet().forEach(x->x.getValue());
        } catch (NullPointerException e) {
            System.out.println("encountered error");
        }
        return responseList;
    }


}

