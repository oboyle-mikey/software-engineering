#Import Libraries

library(jsonlite) 
library(httpuv)
library(httr)
library(plotly)

#Authenticte Access

key_d = '227e9260fa07686e97df'
secret_d = 'b4f47b5d53c29adb1ba7754cef2b1a68137117a2'
myapplication <- oauth_app(appname = "Assignment",
                   key = key_d,
                   secret = secret_d)
 
access_token <- oauth2.0_token(oauth_endpoints("github"), myapplication)

token = config(token = access_token)


#Initial State

nameState = c('oboyle-mikey')
myProfile_JSON = content(GET("https://api.github.com/users/oboyle-mikey", token))
myFollowers_JSON = content(GET("https://api.github.com/users/oboyle-mikey/followers", token))
myFollowers_R = jsonlite::fromJSON(jsonlite::toJSON(myFollowers_JSON))
userNames = myFollowers_R$login

#Creating Dataframe
nameState = c()
follow = c()

#My Followers
for(i in 1:length(userNames)){
  nameState = c(nameState, paste0("oboyle-mikey.",userNames[i]))
  theirProfile_JSON = content(GET(paste0("https://api.github.com/users/",userNames[i]), token))
  theirProfile_R = jsonlite::fromJSON(jsonlite::toJSON(theirProfile_JSON))
  follow = c(follow, theirProfile_R$followers)
}



#My Followers Followers
for(i in 1:length(userNames)){
  theirFollowers_JSON = content(GET((paste0("https://api.github.com/users/",userNames[i], "/followers"))))
  theirFollowers_R = jsonlite::fromJSON(jsonlite::toJSON(theirFollowers_JSON))
  theirUserNames = c(theirFollowers_R$login)
  for(j in 1:length(theirUserNames)){
      nameState = c(nameState, paste0("oboyle-mikey.",userNames[i],".", theirUserNames[j]))
      theirFollowersProfile_JSON = content(GET(paste0("https://api.github.com/users/",theirUserNames[j]), token))
      theirFollowersProfile_R = jsonlite::fromJSON(jsonlite::toJSON(theirFollowersProfile_JSON))
      follow = c(follow, theirFollowersProfile_R$followers)
  }
}


#For each user we need the following format to import into d3.js Hierarchical Edge Building
# 
# [
#   {
#     "name" : "username",
#     "size" : no_followers,
#     "imports" : ["f1", "f2", "f3", .....]
#   },
#     etc..
# ]



