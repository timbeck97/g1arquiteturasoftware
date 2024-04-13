#!/bin/bash

URL="http://localhost:8081/service1/message"


TOKEN="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJkY2h1WjJtdlNiS09LQjlEY1BYU2EzcVozbW9Vd2Y0TE1mVUJmNVZneXVVIn0.eyJleHAiOjE3MTI5ODE3MTAsImlhdCI6MTcxMjk4MDgxMCwiYXV0aF90aW1lIjoxNzEyOTgwODEwLCJqdGkiOiI5YzE5OTgxZS04ZDYxLTQ1OTEtYTVhZS03MjU3YmI2Njk0ZjciLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvcmVhbG1zL2FycXVpdGV0dXJhZzEiLCJzdWIiOiI5YzExOTMxNy03NTI3LTRiNWYtODEyZS1mZmNiNjVjNmZjMDIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhcnF1aXRldHVyYV9jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiOWI0NTZjZmQtNTI2NS00YzI4LTgyYTktMjAzMjE4MjVkODZhIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vbG9jYWxob3N0OjgwODEiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIlVTRVIiXX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6IjliNDU2Y2ZkLTUyNjUtNGMyOC04MmE5LTIwMzIxODI1ZDg2YSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6IlRpbSBNb3JnZW5zdGVybiIsInByZWZlcnJlZF91c2VybmFtZSI6InRpbWJlY2siLCJnaXZlbl9uYW1lIjoiVGltIiwiZmFtaWx5X25hbWUiOiJNb3JnZW5zdGVybiIsImVtYWlsIjoidGltYmVjazE5OTdAaG90bWFpbC5jb20ifQ.Gj5KAxRSu1cgaxo9qkKdn_DdOfgzuUJ3JDPuZqs4d4Q815Xg0UzPDInX_n57qa-s0gDKPimo-PbgLJ_WTWkHIJK6Ors4oCkCUj5CfE8sjwf_9NcOBTNoFJDY9XVUYbzprdz3g-amOw8UfGS1-7kUrjxw2CpXyOvJG1h-GFTVxvOhg9nG-gNeHjUfpUggtdFEDYYAu1GgQW2D66EtgGOgNionb1cOHqmEiOzaHpHx-jOHs3Kt6ObPja1EbN_Tk42gVm63yqPIAJ3u57QS08HY6ro6kkpZJ6FLzbqmCfPlsMbqQcVzpeAxUzPVe_UWadlMmC_4hamXUADSIxMLkx4VPg"


for i in {1..6}
do
    	http_code=$(curl -X GET "$URL" -H "Authorization: Bearer $TOKEN" -s -w "%{http_code}" -o /dev/null)
        if [[ "$http_code" == "200" ]]; then
        echo "Requisição $i foi bem-sucedida com código de status HTTP 200."
	 fi
	 if [[ "$http_code" == "401" ]]; then
        echo "Requisição $i ocorreu com erro código de status HTTP 401 - Unauthorized."
	 fi
	  if [[ "$http_code" == "429" ]]; then
        echo "Requisição $i ocorreu com erro código de status HTTP 429. Too Many Request"
	 fi

    echo
done