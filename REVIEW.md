### Questions I would have for developers

- I would want to work with developers to standardize how we select elements on the page. That way the tests would be more maintainble in the future.
- I would spend some time learning the architecture of the site. This would help me improve the architecture of the page objects and allow me to write more re-usable code.

### Testing all the links on each page

*I tried writing a test the will check each link on the page as long as its an roomstogolink. Its good for making sure links are not broken, however it does not check if links are correct. If we wanted to verify links are correct then we should be pulling links for a static list so that there is not a mismatch between dev links and qa expected links.*

### Testing mobile functionality

*Emulating the devices in chrome works really well. This atleast sends the devices correct user-agent to the site and emulates the screen and the tests are just a cheap as a normal desktop test. I don't think emulating hardware of devices or running tests on real devices is worth it. Those test would be much slower and more expensive to run as well as, outside the scope of an automated UI test.*