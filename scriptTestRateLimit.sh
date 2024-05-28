#!/bin/bash

URL="http://localhost:8081/service1/message"

TOKEN="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI2YWVCZC1ST2VRVTRDVlBqSW15elQzQVhHRTRGWTNYXzRMZ0phUzlJM0VrIn0.eyJleHAiOjE3MTY4NTQ4ODIsImlhdCI6MTcxNjg1NDU4MiwiYXV0aF90aW1lIjoxNzE2ODU0NTgxLCJqdGkiOiJiOWRhNjMwYi0xZjRlLTQ0NDQtOGU1My0xZWUyMDRmNDE3M2MiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvcmVhbG1zL2FycXVpdGV0dXJhZzEiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMjRkMWVkZTUtOTQyOC00Mjg3LTkxOTAtY2EyMjM0YTBiZGE0IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYXJxdWl0ZXR1cmFfY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6ImQxNzUzNDQwLWJhZTMtNDYyYy05YjlmLWNiZTJkZDViMDMwNyIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cHM6Ly9vaWRjZGVidWdnZXIuY29tIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLWFycXVpdGV0dXJhZzEiLCJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiZDE3NTM0NDAtYmFlMy00NjJjLTliOWYtY2JlMmRkNWIwMzA3IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoidGltYiBiZWNrIiwicHJlZmVycmVkX3VzZXJuYW1lIjoidGltYmVjayIsImdpdmVuX25hbWUiOiJ0aW1iIiwiZmFtaWx5X25hbWUiOiJiZWNrIiwiZW1haWwiOiJ0ZXN0ZUBlbWFpbCJ9.hq-WJhxR5UEe6n2sIpx_tHoSx9i_rpipPZsdCaOrhYMNDDFEOKIpDwl3X1Xdb3jwqBQzbwyDhBkKRKPt5ac0Jof8gJz_4hOLo93AI2U99mANvWrGZnaAmuN1WdVv0Nr8w2GIClXZ57YcuszyMynFObTZ6pVCaAN4q_gwHhZI-tqh2tSYxjYY-ermINiAkDigYnunGzro-HyaPXgQy7nDOB-z1qwpYSrfVB5caLZHcObEqrPxzyIpCGSlUu5FrxiR9689fE0FYQ8ZQbaVoQxXidi3Dlno7TcCsujapLbeIoFCnyINy15UK88FAJYtqYYPUWMECY9B_Ghcqp9NTsa2DQ"


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