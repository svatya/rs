<html>
<head>
    <title>Kentico message</title>
</head>
<body>
<#-- 
  JSON test:
  string: ${kentico} <br>
-->
<#assign jsonKentico = kenticoDefinition?eval>
<#list jsonKentico.item.elements as item_type, item>
<#-- ${item_type}  -->
    <#if item.type = "text">
        <div class="textLabel">
            ${item.value?html}
        </div>
    </#if>
    <#if item.type = "rich_text">
        <div class="richTextLabel">
            ${item.value}
        </div>
    </#if>
    <#if item.type = "number">
        <div class="number">
            ${item.value}
        </div>
    </#if>
</#list>
<#-- 
  a: ${jsonObj.a}<br>
  b: ${jsonObj.b}<br>
 -->
</body>
</html>