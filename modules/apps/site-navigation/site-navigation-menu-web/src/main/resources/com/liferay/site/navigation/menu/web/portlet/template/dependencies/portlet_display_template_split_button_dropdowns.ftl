<#include "${templatesPath}/NAVIGATION-MACRO-FTL" />

<#if !entries?has_content>
	<#if themeDisplay.isSignedIn()>
		<div class="alert alert-info">
			<@liferay.language key="there-are-no-menu-items-to-display" />
		</div>
	</#if>
<#else>
	<#assign
		portletDisplay = themeDisplay.getPortletDisplay()

		navbarId = "navbar_" + portletDisplay.getId()
	/>

	<div id="${navbarId}">
		<ul class="navbar-site split-button-dropdowns">
			<#assign navItems = entries />

			<#list navItems as navItem>
				<#assign showChildrenNavItems = (displayDepth != 1) && navItem.hasBrowsableChildren() />

				<#if navItem.isBrowsable() || showChildrenNavItems>
					<#assign
						nav_item_caret = ""
						nav_item_css_class = ""
						nav_item_href_link = ""
					/>

					<#if navItem.isChildSelected() || navItem.isSelected()>
						<#assign nav_item_css_class = "active" />
					</#if>

					<#if showChildrenNavItems>
						<#assign toggle_text>
							<@liferay.language key="toggle" />
						</#assign>

						<#assign nav_item_caret = "<button aria-expanded='false' aria-haspopup='true' class='${nav_item_css_class} btn btn-secondary dropdown-toggle' data-toggle='liferay-dropdown' type='button'><span class='caret'></span><span class='sr-only'>${toggle_text}</span></button>" />
					</#if>

					<#if navItem.isBrowsable()>
						<#assign nav_item_href_link = "href='${navItem.getURL()}' ${navItem.getTarget()}" />
					</#if>

					<li>
						<a aria-labelledby="layout_${portletDisplay.getId()}_${navItem.getLayoutId()}" class="${nav_item_css_class} btn btn-secondary" ${nav_item_href_link}><span>${navItem.getName()}</span></a>${nav_item_caret}

						<#if showChildrenNavItems>
							<ul aria-expanded="false" class="child-menu dropdown-menu" role="menu">
								<@buildChildrenNavItems
									displayDepth=displayDepth
									navItem=navItem
								/>
							</ul>
						</#if>
					</li>
				</#if>
			</#list>
		</ul>
	</div>

	<@liferay_aui.script use="liferay-navigation-interaction">
		var navigation = A.one('#${navbarId}');

		Liferay.Data.NAV_INTERACTION_LIST_SELECTOR = '.navbar-site';
		Liferay.Data.NAV_LIST_SELECTOR = '.navbar-site';

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}
	</@>
</#if>