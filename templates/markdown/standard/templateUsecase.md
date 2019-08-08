
---
${subtype.typeName}
### ${ident} | ${name}
${description.summary}

O **actors** : *${actorsInline}*

<#if parameters?has_content>
O **parameter**  
	<#list parameters as parameter>
-> *${parameter.content}*  
		<#if parameter.note??>
${parameter.note}  
		</#if>
	</#list>
</#if>	

<#if notes?has_content>
O **notes**  
	<#list notes as note>
- <small>(${note.stereotype})</small> ${note.content}  
	</#list>
</#if>	

<#if additionalInfos?has_content>
	<#list additionalInfos as num, info>
O **additional infos #${num}**  
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


O **state** : (${state.formatedUpdate}) ${freemarks.progressBarWithLabel}  ${state.text}  

<#if processInstructions?has_content>
Instructions  
    <#list processInstructions as pi>
o (${pi?index}) ${pi.process}: ${pi.textN2E}  
    </#list>
</#if>