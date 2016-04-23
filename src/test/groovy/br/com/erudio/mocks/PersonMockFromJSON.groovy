package br.com.erudio.mocks

class PersonMockFromJSON {

public static final String PERSON = """{  
   "idPerson":2,
   "name":"ONE PERSON 1",
   "email":"a@b.c",
   "phone":"+55(34)91234-5671",
   "cpf":"175.321.061-31",
   "birthDayDate":1460082852486,
   "insertDate":1460082852486,
   "login":"login1",
   "password":"1234561",
   "permission":"ADMIN",
   "gender":{  
      "idGender":1,
      "description":"MALE"
   },
   "addresses":[  
      {  
         "idAddress":0,
         "neighborhood":"SOME NEIGHBORHOOD 0",
         "streetName":"STREET NAME 0",
         "postalCode":"34700-370",
         "number":0,
         "complement":"SOME COMPLEMENT 0",
         "publicAreaType":{  
            "idPublicAreaType":1,
            "publicAreaTypeDescription":"MALE"
         },
         "state":{  
            "idState":1,
            "stateName":"SOME STATE NAME"
         },
         "addressType":{  
            "idAddressType":1,
            "description":"ADDRESS TYPE 0"
         },
         "city":{  
            "idCity":1,
            "name":"CITY 0"
         }
      },
      {  
         "idAddress":1,
         "neighborhood":"SOME NEIGHBORHOOD 1",
         "streetName":"STREET NAME 1",
         "postalCode":"34700-371",
         "number":1,
         "complement":"SOME COMPLEMENT 1",
         "publicAreaType":{  
            "idPublicAreaType":1,
            "publicAreaTypeDescription":"MALE"
         },
         "state":{  
            "idState":1,
            "stateName":"SOME STATE NAME"
         },
         "addressType":{  
            "idAddressType":1,
            "description":"ADDRESS TYPE 1"
         },
         "city":{  
            "idCity":1,
            "name":"CITY 1"
         }
      }
   ]
} """

}