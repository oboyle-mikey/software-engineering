#Import Libraries

library(jsonlite) 
library(httpuv)
library(httr)

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
myProfile = fromJSON("https://api.github.com/users/oboyle-mikey")
myFollowers = fromJSON("https://api.github.com/users/oboyle-mikey/followers")
userNames = c(myFollowers$login)

for(i in 1:length(userNames)){
  nameState = c(nameState, paste0("oboyle-mikey.",userNames[i]))
  i = i+1
}
network = userNames


#My Followers Followers
for(i in 1:length(userNames)){
  theirFollowers = fromJSON(paste0("https://api.github.com/users/",userNames[i], "/followers"))
  theirUserNames = c(theirFollowers$login)
  for(j in 1:length(theirUserNames)){
    nameState = c(nameState, paste0("oboyle-mikey.",userNames[i],".", theirUserNames[j]))
    j = j+1
  }
  network = c(network, theirUserNames)
  i = i+1
}

uniqueNet = unique(network)

#Their Followers Followers
for(i in 1:length(uniqueNet)){
  theirFollowers = fromJSON(paste0("https://api.github.com/users/",uniqueNet[i], "/followers"))
  theirUserNames = c(theirFollowers$login)
  network = c(network, theirUserNames)
  i = i+1
}

uniqueNet = unique(network)


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


for(i in 1:uniqueNet(length)){
  name = paste0("oboyle-mikey.",uniqueNet[1])
  theirProfile = fromJSON(paste0("https://api.github.com/users/",name))
  followers = theirProfile$followers
  theirFollowers = fromJSON(paste0("https://api.github.com/users/",uniqueNet[1], "/followers"))
  theirUserNames = c(theirFollowers$login)
  write = c(' name : ', name)
}


