<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div
    class="navbar navbar-inverse navbar-fixed-top"
    role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button
                type="button"
                class="navbar-toggle"
                data-toggle="collapse"
                data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <button
                type="button"
                class="navbar-toggle"
                data-toggle="collapse"
                data-target=".sidebar">
                <span class="sr-only">Toggle sidebar</span>
                <span class="glyphicon glyphicon-circle-arrow-down white"></span>
            </button>
            <a
                class="navbar-brand"
                href="#">FITTEST Tracker</a>
        </div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right">
                <div class="btn-toolbar">
                    <button
                        type="submit"
                        class="btn btn-default">
                        <span class="glyphicon glyphicon-cog"> Profile</span>
                    </button>
                    <button
                        type="submit"
                        class="btn btn-danger">
                        <span class="glyphicon glyphicon-off"> Logout</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>