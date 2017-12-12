data_name = nameState
data_size = follow

inter_dendro = matrix(ncol = 2)
inter_dendro[1,1] = 'oboyle-mikey'
inter_dendro[1,2] = NULL


uN = userNames

for(i in 1:length(uN)){
  inter_dendro[1+i, 1] = uN[i]
  inter_dendri[1+i, 2]
  name = c(name, uN[i])
  parent = c(parent, 'oboyle-mikey')
}

for(i in 1:length(uN)){
  theirFollowers_JSON = content(GET((paste0("https://api.github.com/users/",userNames[i], "/followers"))))
  theirFollowers_R = jsonlite::fromJSON(jsonlite::toJSON(theirFollowers_JSON))
  theirUserNames = c(theirFollowers_R$login)
  for(j in 1:length(theirUserNames)){
    if(length(theirUserNames[j]) != 0 && theirUserNames[j] %in% name == FALSE){
      name = c(name, theirUserNames[j])
      parent = c(parent, uN[i])
    }
  }
}

inter_dendo_dFrame = matric
filePath = '/Users/michaeloboyle/Documents/inter_dend.csv'
file = write.csv(inter_dendo_dFrame, filePath)

