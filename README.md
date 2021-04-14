# Infobip eva

This connector has been created using [infobip](https://www.infobip.com/docs/whatsapp/send-whatsapp-over-api), it shows how to incorporate eva conversational flow.

This application is a Spring Boot app and uses the Azure Kubernetes Service (AKS) to deploy to Azure.

# 1. Deployment

- [Documentation](https://drive.google.com/file/d/1OU4sLIQFaJ0ExFFkSavI4ROIePOWId9-/view?usp=sharing)

## 2. Prerequisites

- Java 1.8+
- Install [Maven](https://maven.apache.org/)
- eva's preinstallation
- An account on [Azure](https://azure.microsoft.com) if you want to deploy to Azure.
- [Infobip](https://www.infobip.com/signup) account and get a phone number 
- kubectl
- docker

## 3. To try this sample locally
- From the root of this project folder:
  - Build the sample using `mvn package`
  - Run it by using `java -DEVADB_DS_URL="put eva db url here" -DEVADB_DS_USER="put eva db user here" -DEVADB_DS_PWD="put eva db pass here" -jar .\target\gidp-eva-infobip-3.2.2.0.jar`

- Test full connectivity using infobip phone number

  - All eva's components must be up locally
  - Add the infobip URL (`http://localhost:8050/conversations`) as a [Any Other Keyword](https://www.infobip.com/docs/numbers/keywords-and-actions)
  - Add the phone number in your phone contacts and open a chat in WhatsApp
  - Send a message


## 4. Infobip channel
## 4.1 Adding Keywords

Open infobip portal > Apps > Numbers

Click on you phone number previously created, add the keyword and set the microservice infobip endpoint deployed on your cloud

Keywords: 
   - IMAGE(keyword bot eva)
   - DOCUMENT(document name)
   - VOICE
   - Keyword to reference eva bot

*Use ANY OTHER KEYWORD to redirect all incoming messages to one specific endpoint*
	
## 4.2 Add Keyword to eva's configuration

Open cockpit home, click on settings.

In parameters add information provided from infobip and eva configuration:

	- whatsapp.infobip.info -> {"omniUrl":"<>","user":"<>","password":"<>","whatsappNumber":"<>","channel":"WHATSAPP","keyword":"<keyword to reference eva bot>"}
	- whatsapp.broker.info -> {"baseUrl":"http://eva-broker:8080","apiKey":"eva API KEY","project":"eva project name","channel":"WhatsApp","os":"Infobip connector","locale":"project language"}
	
*Example:

	- whatsapp.infobip.info -> {"omniUrl":"https://api.infobip.com/omni/1/","user":"victor.ruben.torres.criado@everis.com","password":"123456789","whatsappNumber":"34638202449","channel":"WHATSAPP","keyword":"GIDP"}
	- whatsapp.broker.info -> {"baseUrl":"http://eva-broker:8080","apiKey":"12345678","project":"GIDP WA","channel":"WhatsApp","os":"Infobip connector","locale":"es-ES"}
   
## Further reading

- [Maven Plugin for Azure App Service](https://docs.microsoft.com/en-us/java/api/overview/azure/maven/azure-webapp-maven-plugin/readme?view=azure-java-stable)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Azure for Java cloud developers](https://docs.microsoft.com/en-us/azure/java/?view=azure-java-stable)
- [Activity processing](https://docs.microsoft.com/en-us/azure/bot-service/bot-builder-concept-activity-processing?view=azure-bot-service-4.0)
- [Azure Bot Service Introduction](https://docs.microsoft.com/azure/bot-service/bot-service-overview-introduction?view=azure-bot-service-4.0)
- [Azure Bot Service Documentation](https://docs.microsoft.com/azure/bot-service/?view=azure-bot-service-4.0)
- [Infobip Documentation](https://www.infobip.com/docs/whatsapp/send-whatsapp-over-api)

*Components are not supported
