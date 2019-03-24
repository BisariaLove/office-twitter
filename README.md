* Get user by handle : 
curl -XGET "http://localhost:8080/users?handle=lbisaria"

* Get user by email : 
curl -XGET "http://localhost:8080/users?email=love.bisaria@ticketmaster.com"
 
* Add Tweet : 
curl -XPOST http://localhost:8080/tweets -H "Content-Type: application/json" -d '{"userId": 2, "tweet": "Hello World" }'

* Get LatestTweet :
curl -XPOST http://localhost:8080/tweets -H "Content-Type: application/json" -d '{"userId": 2, "tweet": "Hello World" }'
