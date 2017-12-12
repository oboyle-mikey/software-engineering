var table = d3.csvParse(text)

var root = d3.stratify()
    .id(function(d) { return d.name; })
    .parentId(function(d) { return d.parent;})
    (table);
