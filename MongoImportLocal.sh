#!/bin/bash

echo enter mongo filename with directory
read mongoFile
echo enter file type jsonarray, json, csv, tsv
read fileType
echo enter database name
read databaseName
echo enter collection name
read collectionName

echo importing $mongofile to localhost:27017

# mongoimport <options> <connection-string> <file>

if [[ $fileType == "jsonarray" ]]; then	
	mongoimport -d $databaseName -c $collectionName --jsonArray --uri "mongodb://localhost:27017" --file $mongoFile.json
elif [[ $fileType == "json" ]]; then
	mongoimport -d $databaseName -c $collectionName --type json --uri "mongodb://localhost:27017" --file $mongoFile.json
elif [[ $fileType == "csv" ]]; then
	mongoimport -d $databaseName -c $collectionName --type csv --uri "mongodb://localhost:27017" --file $mongoFile.csv
elif [[ $fileType == "tsv" ]]; then
	mongoimport -d $databaseName -c $collectionName --type tsv --uri "mongodb://localhost:27017" --file $mongoFile.tsv
else
	echo unrecognized file type
fi


