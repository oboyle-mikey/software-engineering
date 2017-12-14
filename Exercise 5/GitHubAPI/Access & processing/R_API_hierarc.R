
myProfile_JSON = content(GET("https://api.github.com/users/oboyle-mikey", token))
myFollowers_JSON = content(GET("https://api.github.com/users/oboyle-mikey/followers", token))
myFollowers_R = jsonlite::fromJSON(jsonlite::toJSON(myFollowers_JSON))
userNames = myFollowers_R$login

#Creating Dataframe 3

nameState = c()

for(i in 1:length(userNames)){
  nameState = c(nameState,("oboyle-mikey"))
  nameState = c(nameState, userNames[[i]])
}

for(i in 1:length(userNames)){
  theirFollowers_JSON = content(GET((paste0("https://api.github.com/users/",userNames[i], "/followers"))))
  theirFollowers_R = jsonlite::fromJSON(jsonlite::toJSON(theirFollowers_JSON))
  theirUserNames = c(theirFollowers_R$login)
  for(j in 1:length(theirUserNames)){
      nameState = c(nameState, userNames[[i]])
      nameState = c(nameState, theirUserNames[[j]])
  }
}

g = make_graph(nameState)

edgeToJSON_igraph = function(graph){
  df <- get.data.frame(graph,what="both")
  vertices <- df$vertices
  edges <- df$edges
  # if the vertex names are unspecified, number them
  if(is.null(df$vertices$name)){
    vertices$name = as.character(sort(unique(unlist(edges))))
  }
  imports <- NULL
  # get all attributes if defined in vertices of the igraph
  output <- apply(
    vertices,MARGIN=1,function(vtx){
      name <- vtx[["name"]]
      if(any(edges[,1]==name)) imports = as.vector(edges[edges[,1]==name,2])
      c(vtx,imports=list(imports))
    }
  )
  output <- unname(output)
  rjson::toJSON(output)
  return( output)
}


writeJSON = edgeToJSON_igraph(g)
filepath = "/Users/michaeloboyle/Documents/hierarch.json"
write_json(writeJSON, filepath)

edgebundle(writeJSON)

