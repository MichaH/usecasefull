
---
${subtype.typeName}
### ${ident} | ${name}
${description.summary}

**actors** : *${actorsInline}*

<#if parameters?has_content>
**parameter**  
	<#list parameters as parameter>
&#8614; *${parameter.content}*  
		<#if parameter.note??>
${parameter.note}  
		</#if>
	</#list>
</#if>	

<#if notes?has_content>
**notes**  
	<#list notes as note>
&#9642; <small>(${note.stereotype})</small> ${note.content}  
	</#list>
</#if>	


**state** : (${state.formatedUpdate}) ${freemarks.progressBarWithLabel}  ${state.text}  

