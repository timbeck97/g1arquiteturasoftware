#!/bin/bash

URL="http://localhost:8081/service1/message"

TOKEN="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJkY2h1WjJtdlNiS09LQjlEY1BYU2EzcVozbW9Vd2Y0TE1mVUJmNVZneXVVIn0.eyJleHAiOjE3MTMxMTYxNjEsImlhdCI6MTcxMzExNTg2MSwiYXV0aF90aW1lIjoxNzEzMTE0OTc5LCJqdGkiOiJlMzdiMWZmYi1iZDM1LTRjZDgtYWFhNC01YmJmMmY4MjhiODkiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvcmVhbG1zL2FycXVpdGV0dXJhZzEiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiZWFlOWQyM2QtZDJhMC00M2I1LTkxNmQtYTMwMWJkOWJmMzMxIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYXJxdWl0ZXR1cmFfY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImViZTgyMGE1LTkxOTktNDliNS1hODFlLTQyZTYzOTYzY2E0ZCIsImFjciI6IjAiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL2xvY2FsaG9zdDo4MDgxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLWFycXVpdGV0dXJhZzEiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiZWJlODIwYTUtOTE5OS00OWI1LWE4MWUtNDJlNjM5NjNjYTRkIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoiVGltIE1vcmdlbnN0ZXJuIiwicHJlZmVycmVkX3VzZXJuYW1lIjoidGltYmVjayIsImdpdmVuX25hbWUiOiJUaW0iLCJmYW1pbHlfbmFtZSI6Ik1vcmdlbnN0ZXJuIiwiZW1haWwiOiJ0aW1iZWNrMTk5N0Bob3RtYWlsLmNvbSJ9.qMabFjWW8yogvtR4TRiHMLUq-776XiZu5VJXQAr0Rm7OlkK5_1Es3IbDdJYUBpqf8pzz5D4hn5_U34ZBAyEUgbVCQyVFK4GAAdAZRHcwjJY8SijzoyMVmFNe5A6WRwadQRp9segN43jxzJGFNUu3Z-vSJtJ-x8-bvXp_gskransEfRbLgtuSeAq2rRdgSpbm93Q4a6oXw7MqvatLsx24JeoHwVy8EqVTgKOdjRuXioabvu7FJbYViQggy6oxJaHgc7izW5bif-tVY-YOFJv6FQp2IyeJtd1vW1x-lZhxFzhvyIidiWXhkQowBnLlvjkMxAdTRkTa_5adFlzLoPkr3A"


for i in {1..50}
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