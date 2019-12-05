# Spring Boot 2

### HTTP-Endpoints
* metrics-endpoint: http://localhost:8889/actuator/metrics -> gibt Übersicht über verfügbare Endpoints
* einzelne Werte können folgendermaßen abgegriffen werden: {metrics-endpoint}/{metric-name}, z.B.
    * http://localhost:8889/actuator/metrics/BookController.allBookCounter
    * http://localhost:8889/actuator/metrics/http.server.requests
    
# TEST
