
---
${subtype}
### ${ident} | ${name}
${description.summary}

**actors** : *${actorsInline}*

<#if parameters?has_content>
**parameter**  
	<#list parameters as parameter>
--> ${parameter.content}  
		<#if parameter.note??>
${parameter.note}  
		</#if>
	</#list>
</#if>	

