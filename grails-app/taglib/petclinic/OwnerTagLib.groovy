package petclinic

class OwnerTagLib {
	static namespace = 'owner'

	Closure entry = { attrs, body ->
		def owner = attrs.get('owner')

		out <<
		"""
			<td>
				${link(action: 'show', id: owner.id) { "${owner.firstName} ${owner.lastName}" }}
			</td>
			<td>${owner.address}</td>
			<td>${owner.city}</td>
			<td>${owner.telephone}</td>
			<td>
		"""

		for (def pet : owner.pets) {
			out <<
			"""
				${pet.name} (${pet.type.name})
				<br />
			"""
		}

		out <<
		"""
			</td>
		"""
	}
}
