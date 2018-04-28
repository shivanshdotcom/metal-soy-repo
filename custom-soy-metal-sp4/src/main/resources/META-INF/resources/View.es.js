import Component from 'metal-component/src/Component';
import core from 'metal/src/core';
import dom from 'metal-dom/src/dom';
import Ajax from 'metal-ajax/src/Ajax';
import Footer from './Footer.es';
import Header from './Header.es';
import Soy from 'metal-soy/src/Soy';
import templates from './View.soy';
import CustomButton from './button/button.es';
import CustomInput from './input-component/input.component.es';
import CustomAlerts from './alerts/alerts.component.es';
import CustomDropdown from './dropdown/dropdown.component.es'; 

class View extends Component {
	constructor(opt_config) {
		super(opt_config);
		this.fetchProcessRequestURL(opt_config.processRequestURL);
		$(".alert-success").addClass("hidden");
		$(".alert-danger").addClass("hidden");
	}
	
	fetchProcessRequestURL(processRequestURL) {
		return processRequestURL;	
	}
	
	getButtonValue(event) {
		console.log('Button Event::',event);
		
		Ajax.request(this.processRequestURL,'GET')
		.then((xhr) => {
		    console.log("xhrResponse:",xhr);
		    console.log("xhrResponse:",xhr.status);
		    if(xhr.status == 200){
		    	$(".alert-success").removeClass("hidden");
				$(".alert-danger").addClass("hidden");
		    }else{
		    	$(".alert-success").addClass("hidden");
				$(".alert-danger").removeClass("hidden");
		    }
		 });
		
	}
	
	getTextValue(event) {
		console.log('Text Event:',event);
	}
	
	getDropdownValue(event) {
		  console.log("getDropdownValue called::",event);
	} 
	
	/**
	 * buttonresponse
	 *
	 * @param processRequestURL
	 */
	getbuttonresponse(event) {
		console.log("Button response successful & URL",this.processRequestURL);
	 }
	
	/**
	 * textfieldresponse
	 *
	 */
	gettextresponse(event) {
		console.log("Textfield response successful");
	 }
}

View.STATE = {
	processRequestURL: {
		value: 'fetchProcessRequestURL'      
	}
}

// Register component
Soy.register(View, templates);

export default View;