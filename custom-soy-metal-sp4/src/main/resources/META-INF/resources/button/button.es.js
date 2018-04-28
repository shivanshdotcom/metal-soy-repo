import templates from './button.soy';
import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

class CustomButton extends Component {
	
	clickHandler(event){
		this.emit('clickEvent',event);   
	} 
   
}

Soy.register(CustomButton, templates);
CustomButton.STATE = {
	text: {
		value: 'Default'
	},
	cssClass: {
		value: 'default'
	}
}


export default CustomButton;
