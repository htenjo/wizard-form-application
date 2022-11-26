Survey.StylesManager.applyTheme("defaultV2");

async function getFormModel(url) {
    const response = await fetch(url);
    const json = await response.json();
    return json;
}

async function postResults(url = '', data = {}) {
    let wizard = {};
    wizard.values = data;
    wizard.state = "ON_VALIDATION";
    const response = await fetch(url, {
        method: 'PUT',
        cache: 'no-cache',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify(wizard)
    });

    console.log("::: Persisted Values");
    console.log(response);
}

async function populateSurvey() {
    let apiUrl = "http://localhost:9090/api/638220668a88ea21fee5e29b"
    let modelUrl = apiUrl + "/model";
    let jsonModel = await getFormModel(modelUrl);

    window.survey = new Survey.Model(jsonModel);
    survey.onComplete.add(function (sender) {
        let dataValues = JSON.stringify(sender.data, null, 3);
        document.querySelector('#surveyResult').textContent = "Result JSON:\n" + dataValues;
        postResults(apiUrl, sender.data);
    });

    ReactDOM.render(<SurveyReact.Survey model={survey}/>, document.getElementById("surveyElement"));
}

populateSurvey()
    .then(data => console.log("::: Form loaded"))
    .catch(error => console.log("::: Error loading form model"));
