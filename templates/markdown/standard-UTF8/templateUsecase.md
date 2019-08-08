
---
${subtype.typeName}
### ${ident} | ${name}
${description.summary}

&#9937; **actors** : *${actorsInline}*

<#if parameters?has_content>
&#10004; **parameter**  
	<#list parameters as parameter>
&#8614; *${parameter.content}*  
		<#if parameter.note??>
${parameter.note}  
		</#if>
	</#list>
</#if>	

<#if notes?has_content>
&#9997; **notes**  
	<#list notes as note>
&#9642; <small>(${note.stereotype})</small> ${note.content}  
	</#list>
</#if>	

<#if additionalInfos?has_content>
	<#list additionalInfos as num, info>
&#10133; **additional infos #${num}**  
${info.content}  
		<#if info.notes?has_content>
			<#list info.notes as note>
* ${note}
			</#list>
		</#if>	
		<#if info.code??>
````
${info.code}
````
		</#if>

	</#list>
</#if>	


&#9203; **state** : (${state.formatedUpdate}) ${freemarks.progressBarWithLabel}  ${state.text}  

<#if processInstructions?has_content>
&#9745; Instructions  
    <#list processInstructions as pi>
&#9744; (${pi?index}) ${pi.process}: ${pi.textN2E}  
    </#list>
</#if>