package cl.prestabanco.addresses_server.repositories;
import cl.prestabanco.addresses_server.entities.AddressesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressesEntity, Integer> {
    public AddressesEntity findByStreetAddressAndNumberAddressAndCommuneAddressAndRegionAddressAndCountryAddress(
            String streetAddress,
            Integer numberAddress,
            String communeAddress,
            String regionAddress,
            String countryAddress
    );
}
