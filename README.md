# Bahmni-AsgardConsumer
Improving Integration between Bahmni using Messaging-Oriented Middleware (MOM)

This project aims to replace the Bahmni Atom feed with an MOM solution, improving interoperability between all possible Bahmni systems by synchronizing databases. final aim is to make a system that can easily integrate with other open-source systems with minimal need for development.

## Setup Instructions 
(13th May 2023)-Present
The system can currently synchronize Bahmni ERM and Odoo patients and drugs.Proof of concept and end of study project. 

### 1. **Append Services in docker-compose.yml**

1. Add necessary services to **docker-compose.yml**.
2. Necessary services are found in **/scripts/Append.txt**, ensuring the locations of attached **AsgardConsumer.jar** and **Dockerfile**.

### 2. **Run Your Appended docker-compose.yml**

1. Execute `docker compose up`.

### 3. **Enable Binlog on OpenMRS**

1. Copy the contents of **binlogconfig.txt** file.
2. Paste the contents into the running **openmrsdb** container in the file **/etc/mysql/mysql.cnf** and save.
3. Restart the **openmrsdb** container.

### 4. **Grant Debezium User in OpenMRSDB**

1. Run **/scripts/PrivelageScript.txt** in the **openmrs MySQL.sh**.

### 5. **Configure Kafka Broker**

1. Run the script in **/scripts/CurlScript.txt** in the terminal.

### 6. **Restart Consumer Container**

1. Stop and restart the consumer container.

### 7. **Stop OdooConnect Container**

1. Stop the **odooconnect** container.

## Contributing

By helping in ways I can improve Project and perhaps remove the Atom feed method, and need for development,suggestions always welcomed, Thank You? M

Instructions on how to contribute to your project.
