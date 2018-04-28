import templates from './input.component.soy';
import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

class CustomInput extends Component {
	 	 
	changeHandler(event){
		this.emit('changeEvent', event);  
	}
}
Soy.register(CustomInput, templates);
export default CustomInput; 
 
