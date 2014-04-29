
			<tr>
				<td>
					<g:link action="show" id="${ownerBean.id}">${ownerBean.firstName} ${ownerBean.lastName}</g:link>
				</td>
				<td>${ownerBean.address}</td>
				<td>${ownerBean.city}</td>
				<td>${ownerBean.telephone}</td>
				<td>
				<g:each in="${ownerBean.pets?.sort{ a, b -> a.name <=> b.name }}" var="pet">
					${pet.name} (${pet.type.name})
					<br />
				</g:each>
				</td>
			</tr>