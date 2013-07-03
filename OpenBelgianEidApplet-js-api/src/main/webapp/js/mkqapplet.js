//small fix for logging in old IE-browsers...
if(!window.console){ window.console = function(){}; } 

//see if the applet is loaded
var appletLoaded = false;

//start the applet, should always be called.
function startApplet()
{
	var parameters = {};
	var minimumJavaVersion = "1.7";
	var attributes = 
	{
			id : "mkq_applet",
			codebase: 'applet',
			archive: 'MKQApplet.jar',
			code: 'com/trust1t/ocs/belgianeidsigning/applet/MKQApplet.class',
			name: 'mkqapplet',
			width: '0',
			height: '0'
	};
	deployJava.runApplet(attributes, parameters, minimumJavaVersion);
}

/* public synchronous GET Functions */

/**
 * gets the card ATR
 */
function getCardAtr()
{
	return mkq_applet.getExternalInputDelegate().getCardAtr();
}

/**
 * Gets the current version of the applet. Use this to be your first method to check
 * if the applet is integrated correctly.
 */
function getAppletVersion()
{
	return mkq_applet.getExternalInputDelegate().getVersion();
}

/**
 * synchronous function to get the identity of the person
 * @returns Identity
 */
function getIdentity()
{
	return mkq_applet.getExternalInputDelegate().getIdentity();
}

function getAddress()
{
	return mkq_applet.getExternalInputDelegate().getAddress();
}

function getAuthenticationCertificate()
{
	return mkq_applet.getExternalInputDelegate().getAuthenticationCertificate();
}

function getSigningCertificate() 
{
	return mkq_applet.getExternalInputDelegate().getSigningCertificate();
}

function getCACertificate()
{
	return mkq_applet.getExternalInputDelegate().getCACertificate();
}

function getRootCACertificate()
{
	return mkq_applet.getExternalInputDelegate().getRootCACertificate();
}

function getRRNCertificate()
{
	return mkq_applet.getExternalInputDelegate().getRRNCertificate();
}

function getAuthenticationCertificateChain()
{
	return mkq_applet.getExternalInputDelegate().getAuthenticationCertificateChain();
}

function getSigningCertificateChain()
{
	return mkq_applet.getExternalInputDelegate().getSigningCertificateChain();
}

function getCACertificateChain()
{
	return mkq_applet.getExternalInputDelegate().getCACertificateChain();
}

function getRRNCertificateChain()
{
	return mkq_applet.getExternalInputDelegate().getRRNCertificateChain();
}

function setPin(pinCode)
{
	mkq_applet.getExternalInputDelegate().setPin(pinCode);
}

function verifyPin()
{
	return mkq_applet.getExternalInputDelegate().verifyPin();
}

function signRsa(toEncrypt)
{
	return mkq_applet.getExternalInputDelegate().signRsa(toEncrypt);
}




/* 
 * asynchronous callback functions 
 * These should never be called directly, instead, they are used by the 
 * applet
 */

/**
 * this method will be called once the applet is loaded, is delegated to onAppletLoaded()
 */
function _onAppletLoaded()
{
	console.log("received from backend: applet loaded");
	if (typeof onAppletLoaded  === 'function') 
	{ 
		onAppletLoaded();
	}
	else
	{
		console.log("[alert] function onAppletLoaded does not exist.");
	}	
}

/**
 * This method will be called when an eid card is detected, it is delegated to onCardDetected()
 */
function _onCardDetected()
{
	console.log("received from backend: card detected");
	if (typeof onCardDetected  === 'function') 
	{ 
	
		onCardDetected();
	}
	else
	{
		console.log("[alert] function onCardDetected does not exist.");
	}
}

function _onCardRemoved()
{
	console.log("received from backend: card removed loaded");
	if (typeof onCardRemoved  === 'function') 
	{ 
		onCardRemoved();
	}
	else
	{
		console.log("[alert] function onCardRemoved does not exist.");
	}
}

/* asynchronous functions, callbacks and delegates */
/**
 * help method for not implemented callback functions
 */
function notYetImplemented()
{
	console.log("the method that should be here isn't implemented yet.");
}

/**
 * definition of different callbacks
 */
var onGetIdentityCallback = notYetImplemented;
var onGetPhotoCallback = notYetImplemented;
var onGetAddressCallback = notYetImplemented;
var onGetAuthenticationCertificateCallback = notYetImplemented;
var onSigningCertificateCallback = notYetImplemented;
var onCACertificateCallback = notYetImplemented;
var onRootCACertificateCallback = notYetImplemented;
var onRRNCertificateCallback = notYetImplemented;

/*
 *	async function calls
 */

function getIdentityAsync(_callback)
{
	onGetIdentityCallback = _callback;
	return mkq_applet.getExternalAsyncInputDelegate().getIdentity('onGetIdentityCallback');
}

function getPhotoAsync(_callback)
{
	onGetPhotoCallback = _callback;
	return mkq_applet.getExternalAsyncInputDelegate().getPhoto('onGetPhotoCallback');
}

function getAddressAsync(_callback)
{
	onGetAddressCallback = _callback;
	return mkq_applet.getExternalAsyncInputDelegate().getAddress('onGetAddressCallback');
}

function getAuthenticationCertificateAsync(_callback)
{
	onGetAuthenticationCertificateCallback = _callback;
	return mkq_applet.getExternalAsyncInputDelegate().getAuthenticationCertificate('onGetAuthenticationCertificateCallback');
}

function getSigningCertificateAsync(_callback)
{
	onSigningCertificateCallback = _callback;
	return mkq_applet.getExternalAsyncInputDelegate().getSigningCertificate('onSigningCertificateCallback');
}

function getCACertificateAsync(_callback)
{
	onCACertificateCallback = _callback;
	return mkq_applet.getExternalAsyncInputDelegate().getCACertificate('onCACertificateCallback');
}

function getRootCACertificateAsync(_callback)
{
	onRootCACertificateCallback = _callback;
	return mkq_applet.getExternalAsyncInputDelegate().getRootCACertificate('onRootCACertificateCallback');
}

function getRRNCertificateAsync(_callback)
{
	onRRNCertificateCallback = _callback;
	return mkq_applet.getExternalAsyncInputDelegate().getRRNCertificate('onRRNCertificateCallback');
}


