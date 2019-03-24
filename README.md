* Get user
curl -XGET "http://localhost:8080/users?handle=lbisaria22"
 
* Add Tweet
curl -XPOST http://localhost:8080/tweets -H "Content-Type: application/json" -d '{"userId": 2, "tweet": "Hello World" }'

* Get LatestTweet
curl -XPOST http://localhost:8080/tweets -H "Content-Type: application/json" -d '{"userId": 2, "tweet": "Hello World" }'
