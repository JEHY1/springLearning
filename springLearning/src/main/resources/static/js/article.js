function httpRequest(url, method, body, success, fail){
    fetch(url, {
        method: method,
        headers: {
            "Content-Type": "application/json"
        },
        body: body
    }).then(response => {
        if(response.status == 200 || response.status == 201){
            success();
        }
        else{
            fail();
        }
    });
}

const articleSubmitButton = document.getElementById('articleSubmit-btn');

if(articleSubmitButton){
    function articleSubmitSuccess(){
        alert('Submit Success');
        location.replace('/home');
    }

    function articleSubmitFail(){
        alert('Submit Fail');
        location.replace('/home');
    }

    articleSubmitButton.addEventListener('click', () => {
        let body = JSON.stringify({
                title: document.getElementById('articleTitle').value,
                content: document.getElementById('articleContent').value
        });
        httpRequest(`/article`, 'POST', body, articleSubmitSuccess, articleSubmitFail);
    });
}

const articleDeleteButton = document.getElementById('articleDelete-btn');

if(articleDeleteButton){
    function articleDeleteSuccess(){
        alert('Delete Success');
        location.replace('/home');
    }

    function articleDeleteFail(){
        alert('Delete Fail');
        location.replace('/home');
    }

    articleDeleteButton.addEventListener('click', () => {
        let body = JSON.stringify({
            id: document.getElementById('articleId').value
        });

        httpRequest(`/article`, 'DELETE', body, articleDeleteSuccess, articleDeleteFail);
    });
}

const articleUpdateButton = document.getElementById('articleUpdate-btn');

if(articleUpdateButton){
    function articleUpdateSuccess(){
        alert('Update Success');
        location.replace('/home');
    }

    function articleUpdateFail(){
        alert('Update Fail');
        location.replace('/home');
    }

    articleUpdateButton.addEventListener('click', () => {
        let body = JSON.stringify({
            id: document.getElementById('articleId').value,
            title: document.getElementById('articleTitle').value,
            content: document.getElementById('articleContent').value
        });

        httpRequest(`/article`, 'PUT', body, articleUpdateSuccess, articleUpdateFail);
    });
}

