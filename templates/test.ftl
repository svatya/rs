<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>Welcome ${user}!</h1>
  <p>Our latest product:
  <a href="${latestProduct.url}">${latestProduct.name}</a>!
  
  JSON test:
  string: ${jsonTest} <br>
  <#assign jsonObj = jsonTest?eval>
  
  a: ${jsonObj.a}<br>
  b: ${jsonObj.b}<br>
</body>
</html>