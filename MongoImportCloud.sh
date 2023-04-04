#!/bin/bash
echo ----------------------------------
echo make sure you are not on NUS wifi
echo ----------------------------------
echo Enter mongo filename with directory:
read mongoFile
echo Enter file type jsonarray, json, csv, tsv:
read fileType
echo Enter database name:
read databaseName
echo Enter collection name:
read collectionName
echo Enter URI:
read uriName

echo importing $mongofile to $uriName
# mongoimport --uri="mongodb://mongo:36qeQdmKMhrEdjEGhjbr@containers-us-west-85.railway.app:7513/games" --authenticationDatabase=admin --collection=boardgames --jsonArray --file=./03-Scripts/game.json
# mongoimport <options> <connection-string> <file>

if [[ $fileType == "jsonarray" ]]; then	
	mongoimport --uri=$uriName/$databaseName --authenticationDatabase=admin -c $collectionName --jsonArray --file $mongoFile.json
elif [[ $fileType == "json" ]]; then
	mongoimport --uri=$uriName/$databaseName --authenticationDatabase=admin -c $collectionName --type json --file $mongoFile.json
elif [[ $fileType == "csv" ]]; then
	mongoimport --uri=$uriName/$databaseName --authenticationDatabase=admin -c $collectionName --type csv --file $mongoFile.csv
elif [[ $fileType == "tsv" ]]; then
	mongoimport --uri=$uriName/$databaseName --authenticationDatabase=admin -c $collectionName --type tsv --file $mongoFile.tsv
else
	echo unrecognized file type
fi


