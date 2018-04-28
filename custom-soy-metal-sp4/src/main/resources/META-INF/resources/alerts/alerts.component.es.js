import templates from './alerts.component.soy';
import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

class CustomAlerts extends Component {
}

Soy.register(CustomAlerts, templates);
CustomAlerts.STATE = {}

export default CustomAlerts;

