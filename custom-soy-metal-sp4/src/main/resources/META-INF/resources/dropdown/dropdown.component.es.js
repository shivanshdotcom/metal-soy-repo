import templates from './dropdown.component.soy';
import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

class CustomDropdown extends Component {
	changeHandler(event){
		console.log("Change Handler of custom dropdown");
		this.emit('valueChangeEvent', event);  
	} 
}
Soy.register(CustomDropdown, templates);

export default CustomDropdown;
