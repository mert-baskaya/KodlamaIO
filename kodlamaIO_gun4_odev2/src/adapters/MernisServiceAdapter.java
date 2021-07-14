package adapters;

import java.rmi.RemoteException;

import abstractEntitites.CustomerCheckService;
import entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
import utils.Utils;

public class MernisServiceAdapter implements CustomerCheckService {
	KPSPublicSoapProxy kpsPublic = new KPSPublicSoapProxy();

	@Override
	public boolean checkCustomer(Customer customer) {
		
		boolean result = false;
		
		if(Utils.isTCKNCorrect(customer.getNationalIdentity())) {
			try {
				result = kpsPublic.TCKimlikNoDogrula(
						Long.valueOf(customer.getNationalIdentity()), 
						customer.getFirstName().toUpperCase(), 
						customer.getLastName().toUpperCase(), 
						customer.getDateOfBirth());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Hatali kimlik no girisi yapildi, mernis cagrisi yapilmadi");
			return result;
		}
		
		
		System.out.println("Mernis cagrisi yapildi: " + result);
		return result;
	}

}
