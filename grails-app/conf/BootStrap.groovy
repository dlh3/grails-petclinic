import org.grails.samples.Owner
import org.grails.samples.Pet
import org.grails.samples.PetType
import org.grails.samples.Speciality
import org.grails.samples.Vet

class BootStrap {

	def init = { servletContext ->
		if (!Speciality.count()) {
			// Specialities
			def radiology = new Speciality(name: 'radiology').save(failOnError: true)
			def surgery =   new Speciality(name: 'surgery').save(failOnError: true)
			def dentistry = new Speciality(name: 'dentistry').save(failOnError: true)

			// Vets
			new Vet(firstName: 'James', lastName: 'Carter').save(failOnError: true)
			new Vet(firstName: 'Helen', lastName: 'Leary')
					.addToSpecialities(radiology)
					.save(failOnError: true)
			new Vet(firstName: 'Linda', lastName: 'Douglas')
					.addToSpecialities(surgery)
					.addToSpecialities(dentistry)
					.save(failOnError: true)
			new Vet(firstName: 'Rafael', lastName: 'Ortega')
					.addToSpecialities(surgery)
					.save(failOnError: true)
			new Vet(firstName: 'Henry', lastName: 'Stevens')
					.addToSpecialities(radiology)
					.save(failOnError: true)
			new Vet(firstName: 'Sharon', lastName: 'Jenkins').save(failOnError: true)

			// Owners
			def owner1 = new Owner(firstName: 'Dave', lastName: 'Hughes', address: '353 Hythe Ave', city: 'Burnaby', telephone: '7786887760')
				.save(failOnError: true)
			new Owner(firstName: 'Michelle', lastName: 'Hughes', address: '353 Hythe Ave', city: 'Burnaby', telephone: '6045243304')
				.save(failOnError: true)
			new Owner(firstName: 'Michelle', lastName: 'Wong', address: '353 Hythe Ave', city: 'Burnaby', telephone: '6045243304')
				.save(failOnError: true)

			// Pet types
			for (String type in ['dog', 'lizard', 'cat', 'snake', 'bird', 'hamster']) {
				new PetType(name: type).save(failOnError: true)
			}
			def dogType = PetType.findByName('dog')

			// Pets
			new Pet(name: 'Jack', type: dogType, owner: owner1, birthDate: new Date()).save(failOnError: true)
			new Pet(name: 'Coco', type: dogType, owner: owner1, birthDate: new Date()).save(failOnError: true)
		}
	}
}
